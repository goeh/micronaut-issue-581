package issue;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.Client;
import io.reactivex.Single;

@Client("/")
public interface ControllerTestClient {

    @Post("/test")
    Single<Book> ok(@Header("X-Powered-By") String poweredBy, @Body Book booky);

    @Post("/test")
    Single<Book> fail(@Body Book book, @Header("X-Powered-By") String poweredBy);
}
