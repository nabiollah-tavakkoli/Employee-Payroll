package contracts;

import java.util.ArrayList;

public abstract class MultiContractExchange implements TypeOfContract {
	private ArrayList<TypeOfContract> contractList;
	
	public MultiContractExchange() {
		contractList = new ArrayList<TypeOfContract>();
	}
	
	protected ArrayList<TypeOfContract> getContractList() {
		return contractList;
	}

	public void addContract(TypeOfContract newContract) {
		contractList.add(newContract);
	}
	
	public void modifyAContract(TypeOfContract newContract, int position) {
		if(position < contractList.size() && position >= 0) {
			contractList.remove(position);
			contractList.add(position, newContract);
		}else {
			throw new IndexOutOfBoundsException("the INSERTED POSITION is Incorrect (out of bound)");
		}
		
	}

}
