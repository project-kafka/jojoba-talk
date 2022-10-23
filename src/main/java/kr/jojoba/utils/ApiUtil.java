package kr.jojoba.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

/**
 *
 * example:
 *
 * import static kr.jojoba.utils.ApiUtil.*;
 *
 *
 * @RestController
 * @RequestMapping("/")
 * public class HomeRestController {
 *
 *      @GetMapping
 *      public ApiResult<HomeDto> getHome() {
 *          return success(response);
 *      }
 * }
 *
 */
public class ApiUtil {

    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static <T> ApiResult<?> error(HttpStatus status, String message) {
        return new ApiResult<>(false, null, new ApiError(status, message));
    }

    public static <T> ApiResult<?> error(HttpStatus status, Throwable throwable) {
        return new ApiResult<>(false, null, new ApiError(status, throwable));
    }

    public static class ApiError {
        private final int status;
        private final String message;

        public ApiError(HttpStatus status, String message) {
            this.status = status.value();
            this.message = message;
        }

        public ApiError(HttpStatus status, Throwable throwable) {
            this(status, throwable.getMessage());
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("status", status)
                    .append("message", message)
                    .toString();
        }
    }

    public static class ApiResult<T> {
        private final boolean success;
        private final T response;
        private final ApiError error;

        public ApiResult(boolean success, T response, ApiError error) {
            this.success = success;
            this.response = response;
            this.error = error;
        }

        public boolean isSuccess() {
            return success;
        }

        public T getResponse() {
            return response;
        }

        public ApiError getError() {
            return error;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("success", success)
                    .append("response", response)
                    .append("error", error)
                    .toString();
        }
    }
}
