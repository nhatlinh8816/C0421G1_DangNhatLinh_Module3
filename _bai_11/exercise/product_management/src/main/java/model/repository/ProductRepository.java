package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepository implements ProductRepositoryImp {
    // tạo 1 danh sách sản phẩm dạng map
    static Map<Integer,Product> productMap = new TreeMap<>();
    static {
        //Product(int id, String name, double price, String description, String producer)
        productMap.put(1,new Product(1,"Iphone",20000000,"Export","China"));
        productMap.put(2,new Product(2,"SAMSUNG",1000000,"Export","USA"));
        productMap.put(3,new Product(3,"Xiaomi",5000000,"Export","Japan"));
        productMap.put(4,new Product(4,"Bphone",100000,"Inland","VietNam"));
        productMap.put(5,new Product(5,"BlackBerry",3000000,"Export","Thailand"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(this.productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }
}
