package entities.enums;

public enum OrderStatus {

    PENDING_PAYMENT(1, "PENDING_PAYMENT"),
    PROCESSING(2, "PROCESSING"),
    SHIPPED(3, "SHIPPED"),
    DELIVERED(4, "DELIVERED");

    private int cod;
    private String descricao;

    private OrderStatus(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static OrderStatus toEnum(Integer cod){
        if (cod == null){
            return null;
        }
        for(OrderStatus x: OrderStatus.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido" + cod);
    }
}
