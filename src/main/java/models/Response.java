package models;

import java.util.List;

public class Response {
    private String type;
    private String code;
    private String message;
    private List<Data> data;

    public Response(String type, String code, String message, List<Data> data) {
        this.type = type;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", " + data.get(0).getKey()+ ": "+ data.get(0).getValue() +
                ", " + data.get(1).getKey() + ": "+ data.get(1).getValue() +
                '}';
    }
}
