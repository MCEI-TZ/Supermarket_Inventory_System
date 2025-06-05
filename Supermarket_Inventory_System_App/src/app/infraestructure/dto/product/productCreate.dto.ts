export interface ProductCreateDTO {
  name: string;
  description?: string;
  barcode: string;
  expirationDate: Date;
  idCategory: number;
}
