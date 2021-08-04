package model.service;

import model.bean.Product;
import model.repository.ProductRepository;
import model.repository.ProductRepositoryImp;

import java.util.List;

public class ProductService implements ProductServiceImp {
    //ProductRepository lấy dữ liệu từ DB, gửi lên ProductService, ProductService gửi lên ProductServlet
    private ProductRepositoryImp productRepositoryImp = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return this.productRepositoryImp.findAll();

    }

    @Override
    public void save(Product product) {
        this.productRepositoryImp.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.productRepositoryImp.findById(id);
    }

    @Override
    public void remove(int id) {
        this.productRepositoryImp.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        this.productRepositoryImp.update(id, product);
    }
}
