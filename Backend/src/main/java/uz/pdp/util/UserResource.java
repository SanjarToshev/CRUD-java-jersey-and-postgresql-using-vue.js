package uz.pdp.util;




import uz.pdp.dao.UserRepository;
import uz.pdp.data.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;



@Path("/users")
 public class UserResource {

    @GET  @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "working...";
    }

    @GET
    @Path("/getAll")
    @Produces({"application/json"})
    public List<Users> getUsers() {
        UserRepository userRepository=new UserRepository();
        return userRepository.getAllUsers();
    }

    @GET
    @Path("get/{id}")
    @Produces({"application/json"})
    public Users getUser(@PathParam("id") int id) {
        UserRepository userRepository = new UserRepository();
        return userRepository.getUser(id);
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addStudent(Users user ){
        UserRepository userRepository = new UserRepository();
        userRepository.saveStudent(user);
        return "success";
    }

    @DELETE
    @Path("/delete/{id}")
    public String deleteUser(@PathParam("id") int id) {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteUsers(id);
        return "Success...";
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(Users user){
        Users obj = new Users();
        obj.setUserId(user.getUserId());
        obj.setUserName(user.getUserName());
        obj.setAge(user.getAge());
        obj.setEmail(user.getEmail());
        UserRepository userRepository = new UserRepository();
        userRepository.updateUser(obj);
        return "Success...";
    }
}