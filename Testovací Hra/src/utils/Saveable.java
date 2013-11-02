package utils;

import java.io.PrintWriter;

public interface Saveable{
	public void save(PrintWriter out);
	public void save(PrintWriter out, String p);
}
