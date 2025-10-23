package example.PromocodeAPI.models;

public class Promocode {
    private Long id;
    private String code;
    private int length;
    private int activations;
    private String description;
    private int discount;
    private boolean isActive;
    private String businessEmail;

    // Геттеры
    public Long getId() { return id; }
    public String getCode() { return code; }
    public int getLength() { return length; }
    public int getActivations() { return activations; }
    public String getDescription() { return description; }
    public int getDiscount() { return discount; }
    public boolean getIsActive() { return isActive; }
    public String getBusinessEmail() { return businessEmail; }

    // Сеттеры
    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setLength(int length) { this.length = length; }
    public void setActivations(int activations) { this.activations = activations; }
    public void setDescription(String description) { this.description = description; }
    public void setDiscount(int discount) { this.discount = discount; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }
    public void setBusinessEmail(String businessEmail) { this.businessEmail = businessEmail; }
}