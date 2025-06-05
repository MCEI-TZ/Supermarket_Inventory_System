export interface ProductStockReadDTO {
  idProductStock: number;
  productName: string;
  branchName: string;
  supplierName: string;
  quantity: number;
  price: number;
  lastRestockDate: Date;
}
