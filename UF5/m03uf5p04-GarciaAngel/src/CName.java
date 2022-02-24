
public class CName extends Component {
	public String name;
	
	public CName(GameObject parent) {
		super(parent);
		this.name = NameMaster.getInstance().getName();
	}

	@Override
	public void update() {
	}

}
