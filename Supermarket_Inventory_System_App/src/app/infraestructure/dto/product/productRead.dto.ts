export interface ProductReadDTO {
  idProduct: number;
  name: string;
  description?: string;
  barcode: string;
  expirationDate: Date;
  categoryName: string;
}
