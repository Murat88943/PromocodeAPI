package example.PromocodeAPI.models;

public class Promocode {
    private Long id;
    private String code;
    private int length;
    private int activations;

    // Геттеры
    public Long getId() { return id; }
    public String getCode() { return code; }
    public int getLength() { return length; }
    public int getActivations() { return activations; }

    // Сеттеры
    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setLength(int length) { this.length = length; }
    public void setActivations(int activations) { this.activations = activations; }
}