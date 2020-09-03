// 1.
SELECT S.Score, COUNT(S2.Score) AS "Rank"
FROM Scores S, (SELECT DISTINCT Score FROM Scores) S2
WHERE S.Score <= S2.Score
GROUP BY S.Id
ORDER BY S.Score DESC;

// 2.
SELECT Score, @rank := @rank + (@prev <> (@prev := Score)) "Rank"
FROM Scores, (SELECT @rank := 0, @prev := -1) init
ORDER BY Score DESC;
