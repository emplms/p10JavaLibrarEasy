package com.emmanuel.plumas.p10JavaLibrarEasyWEB.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emmanuel.plumas.p10JavaLibrarEasyWEB.model.BorrowEntity;
import com.emmanuel.plumas.p10JavaLibrarEasyWEB.proxies.ApiProxy;

@Service
@Qualifier("BorrowService")
public class BorrowService {
	
	@Autowired
	@Qualifier("ApiProxy")
	private ApiProxy apiProxy;
		
	public List<BorrowEntity> getCurrentBorrowByUserLastName(String userLastName){
		List<BorrowEntity> borrowEntities=apiProxy.getBorrowByUserName(userLastName);
		List<BorrowEntity> currentBorrowEntities=new ArrayList<BorrowEntity>();
		Date date=new Date();
		for(BorrowEntity borrowEntity:borrowEntities) {
			if(borrowEntity.getStartDate().compareTo(date)<0 && borrowEntity.getEndDate().compareTo(date)>0) {
				currentBorrowEntities.add(borrowEntity);
			}
		}
		return currentBorrowEntities;
	}
	
	public List<BorrowEntity> getOldBorrowByUserLastName(String userLastName){
		List<BorrowEntity> borrowEntities=apiProxy.getBorrowByUserName(userLastName);
		List<BorrowEntity> oldBorrowEntities=new ArrayList<BorrowEntity>();
		Date date=new Date();
		for(BorrowEntity borrowEntity:borrowEntities) {
			if(borrowEntity.getEndDate().compareTo(date)<0) {
				oldBorrowEntities.add(borrowEntity);
			}
		}
		return oldBorrowEntities;
	}

	public void extendBorrow(Long borrowId) {
		apiProxy.setExtendBorrow(borrowId);
	}
	
	public List<BorrowEntity> getBorrowByBookId(Long bookId){
		List<BorrowEntity> borrowByBookIdEntities=new ArrayList<BorrowEntity>();
		List<BorrowEntity> borrowEntities=apiProxy.getAllBorrows();
		for (BorrowEntity borrowEntity : borrowEntities) {
			if(borrowEntity.getCopyEntity().getBookEntity().getBookId().equals(bookId)) {
				borrowByBookIdEntities.add(borrowEntity);
			}
		}
		return borrowByBookIdEntities;
	}
}
