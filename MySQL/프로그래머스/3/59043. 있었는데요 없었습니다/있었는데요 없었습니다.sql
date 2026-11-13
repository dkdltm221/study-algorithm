-- 코드를 입력하세요
-- 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 
-- 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.

SELECT A.ANIMAL_ID,A.NAME
FROM ANIMAL_INS A JOIN ANIMAL_OUTS N ON A.ANIMAL_ID = N.ANIMAL_ID
WHERE A.DATETIME > N.DATETIME
ORDER BY A.DATETIME ASC;