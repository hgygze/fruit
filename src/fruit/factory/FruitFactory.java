package fruit.factory;
public class FruitFactory {
	
	public <T> T getFruit(Class<T> clazz) {
	    T obj = null;

        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
	}
}