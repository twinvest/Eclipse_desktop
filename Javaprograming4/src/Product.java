
public class Product {
   private String productName;
   private int productPrice;
   private char typeOfproduct;
   
   void setProductName(String productName){
      this.productName = productName;
   }
   String getProductName() {
      return productName; 
   }
   
   void setProductPrice(int productPrice){
      this.productPrice = productPrice;
   }
   int getProductPrice(){
      return productPrice;
   }
   
   void setTypeOfProduct(char typeOfproduct){
      this.typeOfproduct = typeOfproduct;
   }
   char getTypeOfProduct(){
      return typeOfproduct;
   }
}