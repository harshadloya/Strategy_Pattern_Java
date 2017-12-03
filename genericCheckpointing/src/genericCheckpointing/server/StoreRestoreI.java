package genericCheckpointing.server;

import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public interface StoreRestoreI 
{
	public StoreRestoreI createProxy(Class[] classes, StoreRestoreHandler storeRestoreHandler);
}
