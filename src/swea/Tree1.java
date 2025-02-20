package swea;


public class Tree1 {

	public static char[] tree = new char[] { '\u0000', 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I' };
	public static int N = tree.length;
	public static void main(String[] args) {
		System.out.print("전위 순회 : ");
		preOrder(1);
		System.out.println();
		System.out.print("중위 순회 : ");
		inOrder(1);
		System.out.println();
		System.out.print("후위 순회 : ");
		postOrder(1);
		System.out.println();
		
	}

	// 전위 순회 v는 노드의 번호
	public static void preOrder(int v) {
		//v라는 노드의 번호가 유효한지 확인
		if(v < N) {
			//방문처리
			if(tree[v] != ' ')// \u0000도 쳌 해주면 좋아요~~ 대전3반 김규민 좋은 질문
				System.out.print(tree[v]);
			//왼쪽자식 탐방
			preOrder(v*2); 
			//오른쪽자식 탐방
			preOrder(v*2+1);
		}
	}
	
	//중위 순회의 왕! 서울 12반 이유리 이었으나... 아니다.라고 채팅을 쳐버려서 탈락
	//중위 순회의 왕! 서울 12반 유아름 !
	public static void inOrder(int v) {
		//v라는 노드의 번호가 유효한지 확인
		if(v < N) {
			//왼쪽자식 탐방
			inOrder(v*2); 
			//방문처리
			if(tree[v] != ' ')
				System.out.print(tree[v]);
			//오른쪽자식 탐방
			inOrder(v*2+1);
		}
	}
	
	//후위 순회 LRV
	public static void postOrder(int v) {
		//v라는 노드의 번호가 유효한지 확인
		if(v < N) {
			//왼쪽자식 탐방
			postOrder(v*2); 
			//오른쪽자식 탐방
			postOrder(v*2+1);
			//방문처리
			if(tree[v] != ' ')
				System.out.print(tree[v]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
