package pl.sda.java.jsp.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Item {

    private String value;

    private List<Item> lista;

    public Item(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setLista(List<Item> lista) {
        this.lista = lista;
    }

    public List<Item> getLista() {
        return lista;
    }

    void wyswietl(Item item){
        System.out.println(item.getValue());
    }

    @Override
    public String toString() {
        return "Item{" +
                "value='" + value + '\'' +
                ", lista=" + lista +
                '}';
    }

    public static void main(String[] args) {
        List<Item> lista = Arrays.asList(new Item("1"), new Item("2"), new Item("3"));

        Item item = new Item("4");
        item.setLista(lista);

        Consumer<? super Item> consumer = item::wyswietl;
        consumer = System.out::println;
//        lista.stream().forEach(consumer);
//        lista.stream().forEach(System.out::println);

        List<Item> lista1 = Arrays.asList(new Item("11"), new Item("12"), new Item("13"));
        List<Item> lista2 = Arrays.asList(new Item("21"), new Item("22"), new Item("23"));
        Item item1 = new Item("10");
        Item item2 = new Item("20");
        item1.setLista(lista1);
        item2.setLista(lista2);
        List<Item> listaList = Arrays.asList(item1, item2);
        listaList.stream().forEach(System.out::println);
        listaList
                .stream()
                .map(i -> i.getLista())
                .flatMap(l -> l.stream().map(i -> i.getValue()))

                .forEach(System.out::println);
        //11,12,13,21,22,23
    }
}
