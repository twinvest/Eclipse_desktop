
 class PointOne implements UpperCasePrintable {
	 private int xPos, yPos;
	 
	 PointOne(int x, int y)
	 {
		 xPos=x;
		 yPos=y;
	 }
	 public String toString()
	 {
		 String posInfo="[x pos : "+xPos + ", y pos : " +yPos+"]";
				 return posInfo;
	 }

}
