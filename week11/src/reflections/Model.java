package reflections;

public class Model<T> {

	public ObjectsModel<T> objects() {
		return new ObjectsModel<T>(this.getClass());
	}
	
	
}
