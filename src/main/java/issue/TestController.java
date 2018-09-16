package issue;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

@Controller("/")
public class TestController {

    @Post("/test")
    public Single<Book> ok(@Header("X-Powered-By") String poweredBy, @Body Book book) {
        return Single.just(new Book(poweredBy));
    }
}
