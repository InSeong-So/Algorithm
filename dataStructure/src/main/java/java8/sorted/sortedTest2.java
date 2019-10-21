package java8.sorted;

public class sortedTest2 {

	public sortedTest2(String prioYn, String expsFdC, String prioOr) {
		this.prioYn = prioYn;               // 우선노출여부
		this.expsFdC = expsFdC;             // 영역코드
		this.prioOr = prioOr;               // 노출순위
	}

	public String prioYn;
	public String expsFdC;
	public String prioOr;

	public String getPrioYn() {
		return prioYn;
	}

	public void setPrioYn(String prioYn) {
		this.prioYn = prioYn;
	}

	public String getExpsFdC() {
		return expsFdC;
	}

	public void setExpsFdC(String expsFdC) {
		this.expsFdC = expsFdC;
	}

	public String getPrioOr() {
		return prioOr;
	}

	public void setPrioOr(String prioOr) {
		this.prioOr = prioOr;
	}

	@Override
	public String toString() {
		return "Person [prioYn=" + prioYn + ", expsFdC=" + expsFdC + ", prioOr=" + prioOr + "]";
	}
}
