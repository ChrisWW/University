// 2. Łączną ilość środków pozostałych na kartach kredytowych osób w bazie, w podziale na waluty

db.people.mapReduce(
  function () {
    this.credit.forEach(e => {
      emit(e.currency, e.balance);
    });
  },
  function (key, values) {
    return Array.sum(values);
  },
  { out: 'balance_sums' }
);
