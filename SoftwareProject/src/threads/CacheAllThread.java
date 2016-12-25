package threads;

import java.io.IOException;

import utilities.Cacher;

public class CacheAllThread implements Runnable{

	@Override
	public void run() {
		try {
			Cacher.cacheAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
