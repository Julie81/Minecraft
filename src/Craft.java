
public class Craft {
	
	Item[] emptyLine= {null,null,null};
	Item[][] items;
	
	public Craft(Item[][] items){
		this.items = items;
	}
	
	public void UpperLeft(){
		
		int cptUpper = 0;
		
		//Upper
		while(items[0][0] == null && items[0][1] == null && items[0][2] == null && cptUpper<2){
			items[0] = items[1];
			items[1] = items[2];
			items[2] = emptyLine;
			cptUpper++;
		}
		
		int cptLeft = 0;
		
		//left
		while(items[0][0] == null && items[1][0] == null && items[2][0] == null && cptLeft<2){
			for(int i=0;i<3;i++){
				for(int j=1;j<3;j++){
					items[i][j-1] = items[i][j];
				}
				items[i][2] = null;
			}
			cptLeft++;
		}
	}
	
	public boolean compareTo(Craft craft){
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				if(this.items[i][j] == null && craft.items[i][j] != null){
					return false;
				}
				if(this.items[i][j] != null && craft.items[i][j] == null){
					return false;
				}
				
				if(!((this.items[i][j] == null && craft.items[i][j] == null) || this.items[i][j].compareTo(craft.items[i][j]))){
						return false;
				}

			}
		}
		return true;
	}
}
