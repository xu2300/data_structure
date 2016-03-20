package file_system;

public abstract class Entry{
	protected Directory parent;
	protected long time;
	protected String name;

	public Entry(String n, Directory p){
		name = n;
		parent = p;
		time= System.currentTimeMills();
	}
	public abstract int size();
	public void changeName(String n) { name = n; }
    public String getName() { return name; }
}

public class File  extends Entry{
	private String content;
	private int size;
	public File(String n, Directory p, int sz) {
 		super(n, p);
 		size = sz;
	}
	
	public int size() {return size; }
	public String getContents() { return content; }
	public void setContents(String c) { content = c; }
}

public class Directory extends Entry{
	protected ArrayList<Entry> contents;
	public Directory(String n, Directory p) {
		super(n, p);
		contents = new ArrayList<Entry>();
	}
	
	public int size(){
		int size = 0;
		for(Entry e: contents){
			size+=e.size();
		}
		return size;
	}
	
	public int numberOfFiles(){
		int count;
		for(Entry e:contents){
			if(e instanceof Directory){
				Directory d = (Directory) e;
				count += d.numberOfFiles();
			}
			else if(e instanceof File){
				count ++;
			}
		}
		return count;
	}
	
	public boolean deleteEntry(Entry e){
		return contens.remove(e);
	}
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
	
	
}