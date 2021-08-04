package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductServiceImp {
    List<Product> findAll();        //hiển thị tất cả các sản phẩm
    void save(Product product);     //thêm mới sản phẩm
    Product findById(int id); //tìm kiếm sản phẩm theo tên
    void remove(int id);               //xóa sản phẩm theo id
    void update(int id,Product product);       //sửa sản phẩm theo id

}
