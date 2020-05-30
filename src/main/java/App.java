import com.google.gson.Gson;
import models.CynixShop;
import models.MenWear;
import models.dao.Sql20MenWearDao;
import models.dao.Sql2oShopDao;
import models.exceptions.ApiException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        Sql2oShopDao shopDao;
        Sql20MenWearDao menWearDao;
        Connection conn;
        Gson gson=new Gson();

        staticFileLocation("/public");
        port(getHerokuAssignedPort());

        String connectionString = "jdbc:postgresql://ec2-34-200-72-77.compute-1.amazonaws.com:5432/d76hbp26t1gp7g";
        Sql2o sql2o = new Sql2o(connectionString, "xheugcjqyscryb", "9d62b7aa1616cdf49154abc03f568434554ea902e33f44a26924dedfc5c0eae2");

//        String connectionString = "jdbc:postgresql://localhost:5432/cynix_database";
//        Sql2o sql2o = new Sql2o(connectionString, "linus", "mariano@9496");
        shopDao=new Sql2oShopDao(sql2o);
        menWearDao=new Sql20MenWearDao(sql2o);
        conn=sql2o.open();

//        shops
        get("/","application/json",(request, response) ->
        {
            System.out.println(shopDao.getAll());
            if (shopDao.getAll().size()>0)
            {
                return gson.toJson(shopDao.getAll());
            }else
            {
                throw new ApiException(404,String.format("No Shops in the database"));
            }
        });
        post("/shops/new","application/json",(request, response) ->
        {
            CynixShop shops=gson.fromJson(request.body(),CynixShop.class);
            shopDao.create(shops);
            response.status(201);
            return gson.toJson(shops);
        });

        get("/shops","application/json",(request, response) ->
        {
            System.out.println(shopDao.getAll());
            if (shopDao.getAll().size()>0)
            {
                return gson.toJson(shopDao.getAll());
            }else
            {
                throw new ApiException(404,String.format("No Shops in the database"));
            }
        });

        get("/shop/:id","application/json",(request, response) ->
        {
            int shopId=Integer.parseInt(request.params("id"));
            CynixShop findShop=shopDao.getById(shopId);
            if (findShop!=null)
            {
                return gson.toJson(findShop);
            }else
            {
                throw new ApiException(404,String.format("No shop with id %s found in the database",request.params("id")));
            }
        });

        post("/shops/update/:id","application/json",(request, response) ->
        {
            int shopId=Integer.parseInt(request.params("id"));
            CynixShop findShop=shopDao.getById(shopId);
            if (findShop!=null)
            {
                String name=request.queryParams("name");
                String buildingName=request.queryParams("buildingName");
                String shopNumber=request.queryParams("shopNumber");
                String email = request.queryParams("email");
                String phone = request.queryParams("phone");

                shopDao.update(shopId,name,buildingName,shopNumber,email,phone);
                return gson.toJson(findShop);
            }else
            {
                throw new ApiException(404,String.format("No shop with id %s found in the database",request.params("id")));
            }
        });

        post("/shop/:id/remove","application/json",(request, response) ->
        {
            int shopId=Integer.parseInt(request.params("id"));
            CynixShop shop=shopDao.getById(shopId);
            if (shop!=null)
            {
                shopDao.deleteById(shop.getId());
                return gson.toJson(shopDao.getAll());
            }else
            {
                return gson.toJson(shopDao.getAll());
            }

        });

        post("/shop/clear","application/json",(request, response) ->
        {
            System.out.println(shopDao.getAll());
            if (shopDao.getAll().size()>0)
            {
                shopDao.clearAll();
                return gson.toJson(shopDao.getAll());
            }else
            {
                return gson.toJson(shopDao.getAll());
            }
        });

//        MenWear
        post("/fashion/men/new","application/json",(request, response) ->
        {
            MenWear wear=gson.fromJson(request.body(),MenWear.class);
            menWearDao.create(wear);
            response.status(201);
            return gson.toJson(wear);
        });

        get("/fashion/men","application/json",(request, response) ->
        {
            System.out.println(menWearDao.getAll());
            if (menWearDao.getAll().size()>0)
            {
                return gson.toJson(menWearDao.getAll());
            }else
            {
                throw new ApiException(404,String.format("No men wear found in the database"));
            }
        });

        get("/fashion/men/:id","application/json",(request, response) ->
        {
            int menWearId=Integer.parseInt(request.params("id"));
            MenWear findMenWear=menWearDao.getById(menWearId);
            if (findMenWear!=null)
            {
                return gson.toJson(findMenWear);
            }else
            {
                throw new ApiException(404,String.format("No men wear with id %s found in the database",request.params("id")));
            }
        });

        post("/fashion/men/:id/remove","application/json",(request, response) ->
        {
            int menWearId=Integer.parseInt(request.params("id"));
            MenWear menWear=menWearDao.getById(menWearId);
            if (menWear!=null)
            {
                menWearDao.deleteById(menWear.getId());
                return gson.toJson(menWearDao.getAll());
            }else
            {
                return gson.toJson(menWearDao.getAll());
            }

        });

        post("/fashion/men/clear","application/json",(request, response) ->
        {
            System.out.println(menWearDao.getAll());
            if (menWearDao.getAll().size()>0)
            {
                menWearDao.clearAll();
                return gson.toJson(menWearDao.getAll());
            }else
            {
                return gson.toJson(menWearDao.getAll());
            }
        });

        //        FILTERS
        exception(ApiException.class, (exception, request, response) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            response.type("application/json");
            response.status(err.getStatusCode());
            response.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
