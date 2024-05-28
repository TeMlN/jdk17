package org.example.sealed;

/**
 * Sealed Class 의 목적은 인터페이스를 상속 및 구현하는 클래스를 부모 클래스 레벨에서 제한시키기 위해 사용된다.
 *
 * Sealed Class를 선언하기 위해선 sealed 제어자를 선언 하여야 합니다.
 * 선언 후에 permits 제어자를 통해 상속 및 구현할 서브 클래스명을 선언하여 제한합니다.
 *
 * Sealed Class를 구현 및 상속하는 서브 클래스들은 non-sealed, final 둘중 하나의 제어자를 선언하여야 한다.
 *
 * non-sealed: 추가적인 확장과 구현을 허용한다. ex) public class Palmer extends Chelsea << 허용
 * final: 더이상의 확장과 구현을 허용하지 않는다. ex) public class Palmer extends Chelsea << 컴파일 에러
 */
public sealed interface EPL permits LiverPool, Chelsea, ManchesterUnited {
    Integer getRank();
}
