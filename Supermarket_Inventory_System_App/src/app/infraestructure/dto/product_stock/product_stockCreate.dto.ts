export interface ProductStockCreateDTO {
  IdProduct: number;
  IdBranch: number;
  IdSupplier: number;
  quantity: number;
  price: number;
  lastRestockDate: Date;
}
