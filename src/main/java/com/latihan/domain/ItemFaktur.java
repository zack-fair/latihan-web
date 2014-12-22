package com.latihan.domain;

public class ItemFaktur {

	private Barang barang;
	
	private Integer qty;
	
	private Double harga;
	
	private Double diskonPersen;
	
	public ItemFaktur() {}
	
	public ItemFaktur(Barang barang, Integer qty, Double harga, Double diskonPersen) {		
		this.barang = barang;
		this.qty = qty;
		this.harga = harga;
		this.diskonPersen = diskonPersen;
	}

	public Barang getBarang() {
		return barang;
	}

	public void setBarang(Barang barang) {
		this.barang = barang;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getHarga() {
		return harga;
	}

	public void setHarga(Double harga) {
		this.harga = harga;
	}

	public Double getDiskonPersen() {
		return diskonPersen;
	}

	public void setDiskonPersen(Double diskonPersen) {
		this.diskonPersen = diskonPersen;
	}

	public Double total() {
		if (diskonPersen != null) {
			return qty * (harga - ((diskonPersen / 100) * harga));
		} else {
			return qty * harga;
		}
	}
	
}
