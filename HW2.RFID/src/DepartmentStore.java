public class DepartmentStore {
    public static void main(String[] args) {
        ItemInfo i = new ItemInfo("Dress Shirt","00A5532FF",10.00, "s12345");
        ItemInfoNode node = new ItemInfoNode();
        node.setInfo(i);
        node.getInfo().setCurrent_position("c154");

        ItemInfo i1 = new ItemInfo("Ksubi Jeans","048HH2FFF",30.00, "s13345");
        ItemInfoNode node1 = new ItemInfoNode();
        node1.setInfo(i1);


        ItemInfo i2 = new ItemInfo("Richard Mille","348LL2SDF",205.00, "s02335");
        ItemInfoNode node2 = new ItemInfoNode();
        node2.setInfo(i2);

        ItemInfo i3 = new ItemInfo("Rolex","9I8XX2SDC",100.00, "s00001");
        ItemInfoNode node3 = new ItemInfoNode();
        node3.setInfo(i3);
//        System.out.println(node.getInfo().getRfidTagNumber());
        ItemList list = new ItemList();
        list.insertInfo(node2.getInfo().getName(),node2.getInfo().getRfidTagNumber(),node2.getInfo().getPrice(),node2.getInfo().getOriginal_position());
        list.insertInfo(node3.getInfo().getName(),node3.getInfo().getRfidTagNumber(),node3.getInfo().getPrice(),node3.getInfo().getOriginal_position());
        list.insertInfo(node.getInfo().getName(),node.getInfo().getRfidTagNumber(),node.getInfo().getPrice(),node.getInfo().getOriginal_position());
        list.insertInfo(node.getInfo().getName(),node.getInfo().getRfidTagNumber(),node.getInfo().getPrice(),node.getInfo().getOriginal_position());
        list.insertInfo(node.getInfo().getName(),node.getInfo().getRfidTagNumber(),node.getInfo().getPrice(),node.getInfo().getOriginal_position());
        list.insertInfo(node1.getInfo().getName(),node1.getInfo().getRfidTagNumber(),node1.getInfo().getPrice(),node1.getInfo().getOriginal_position());
        list.insertInfo(node1.getInfo().getName(),node1.getInfo().getRfidTagNumber(),node1.getInfo().getPrice(),node1.getInfo().getOriginal_position());

        list.printAll();
    }
}
