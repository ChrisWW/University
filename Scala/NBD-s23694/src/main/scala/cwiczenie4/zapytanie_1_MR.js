// 1. Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet)

db.people.mapReduce(
  function () {
    emit(this.sex, { weight: this.weight, height: this.height });
  },

  function (key, values) {
    let sWeight = 0;
    let sHeight = 0;

    values.forEach(e => {
      sWeight += e.weight;
      sHeight += e.height;
    });

    return {
      averageWeight: sWeight / values.length,
      averageHeight: sHeight / values.length
    };
  },
  { out: 'average' }
);
