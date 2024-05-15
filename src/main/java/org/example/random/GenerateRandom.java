package org.example.random;

import java.util.Comparator;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class GenerateRandom {
    public static void main(String[] args) {

        /**
         * JDK17에 새롭게 추가된 난수 생성기 모두 출력
         * @description 크게 세가지 그룹으로 나뉜다 LXM, Xoroshiro, Xoshiro
         */
        RandomGeneratorFactory.all()
                .sorted(Comparator.comparing(RandomGeneratorFactory::name))
                .forEach(factory -> System.out.printf("%s\t%s\n",
                        factory.group(),
                        factory.name())
                );

        /**
         * 특정 난수 생성기를 생성하는 방법
         * <pre> {@code RandomGenerator randomGenerator = RandomGenerator.of("생성할 난수 생성기 이름");
         * } </pre>
         * 정확한 난수 생성기 이름을 입력하지 않을 시 IllegalArgumentException 발생
         *
         * ps. 현재 Default 난수 생성기는 LXM 그룹의 L32X64MixRandom 난수 생성기다.
         * 기본 난수 생성기를 사용하기 위해선 아래의 코드를 입력하면 된다.
         * <pre> {@code RandomGenerator randomGenerator = RandomGenerator.getDefault();
         * } </pre>
         * @exception IllegalArgumentException
         */
        RandomGenerator randomGenerator = RandomGenerator.of("Xoshiro256PlusPlus");

        /**
         * 새로운 난수 생성기를 이용해 난수를 생성하는 방법
         */
        int random = randomGenerator.nextInt(10000);
        System.out.println("random = " + random);


        /**
         * 추가된 난수 생성기들은 Thread-Safe 한가?
         * 기존에 존재하던 Legacy 그룹으로 분리된 Random과 SecureRandom외에는 모두 Thread-safe 하지 않다.
         * 따라서 정적인 Factory Method 패턴을 이용해 사용하면 좋을거 같다.
         */

        /**
         * 난수 생성기들의 성능
         * 역설적이게 새로운 난수 생성기들은 Thread-safe 하지 않기 때문에
         * 기존 Random보다 모든 생성기들이 성능이 좋다.
         */
    }
}
