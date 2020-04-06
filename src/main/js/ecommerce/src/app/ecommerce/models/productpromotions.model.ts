export class ProductPromotions {
    id: number;
    productId: number;
    quantity: number;
    price: number;

    constructor(id: number, productId: number, quantity: number, price: number) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
