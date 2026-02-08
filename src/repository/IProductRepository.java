package repository;

import model.Product;

public interface IProductRepository extends IRepository<Product> {
    // Здесь мы уточняем, что работаем именно с Product
}