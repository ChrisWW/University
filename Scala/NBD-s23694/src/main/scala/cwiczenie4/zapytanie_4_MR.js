// 4. Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości

db.people.mapReduce(
  function () {
    emit(this.nationality, { weight: this.weight, height: this.height });
  },
  function (key, values) {
    let sumBmi = 0;
    let heighestBmi = 0;
    let lowestBmi = Infinity;

    values.forEach(person => {
      const heightMeters = person.height / 100;
      const bmi = person.weight / (heightMeters * heightMeters);

      sumBmi += bmi;
      if (bmi > heighestBmi) heighestBmi = bmi;
      if (bmi < lowestBmi) lowestBmi = bmi;
    });

    return { averageBmi: sumBmi / values.length, heighestBmi, lowestBmi };
  },
  { out: 'bmi' }
);
