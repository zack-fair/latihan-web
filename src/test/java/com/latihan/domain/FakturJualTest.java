package com.latihan.domain;

import java.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;

public class FakturJualTest {
	
	@Test
	public void testTotalTanpaDiskon() {
		Barang barang1 = new Barang("BRG1", "Barang1", 100);
		Barang barang2 = new Barang("BRG2", "Barang2", 100);
		FakturJual faktur = new FakturJual("FJ-001", LocalDate.now(), "Kevin", LocalDate.now().plusDays(30));
		faktur.tambah(barang1, 10, 15000.0, null);
		faktur.tambah(barang2, 20, 30000.0, null);
		assertEquals("Total faktur tidak sesuai dengan yang diharapkan.", 750000, faktur.total().longValue());		
	}
	
	@Test
	public void testTotalDenganDiskon() {
		Barang barang1 = new Barang("BRG1", "Barang1", 100);
		Barang barang2 = new Barang("BRG2", "Barang2", 100);
		FakturJual faktur = new FakturJual("FJ-001", LocalDate.now(), "Kevin", LocalDate.now().plusDays(30));
		faktur.tambah(barang1, 10, 15000.0, 10.0);
		faktur.tambah(barang2, 20, 30000.0, 20.0);
		assertEquals("Nilai item pertama harus (10% * Rp15.000,-) * 10 =  Rp135.000,-", 135000, faktur.getItems().get(0).total().longValue());
		assertEquals("Nilai item kedua harus (20% * Rp30.000,-) * 20 =  Rp480.000,-", 480000, faktur.getItems().get(1).total().longValue());
		assertEquals("Total faktur tidak sesuai dengan yang diharapkan.", 615000, faktur.total().longValue());
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void testStokTidakCukup() {
		Barang barang1 = new Barang("BRG1", "Barang1", 50);		
		FakturJual faktur = new FakturJual("FJ-001", LocalDate.now(), "Kevin", LocalDate.now().plusDays(30));
		faktur.tambah(barang1, 100, 15000.0, null);
	}
	
}
