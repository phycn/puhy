package cn.puhy.sofarpc.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author puhongyu
 * 2019/4/25 10:42
 */
@Path("")
public interface MySofaRpcService {
    @GET
    @Path("hello")
    String sayHello();
}
