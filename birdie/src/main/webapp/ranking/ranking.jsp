<!DOCTYPE html>
<html>
<head>
  <title>Golf Ranking</title>
  <%@include file="/include/header.jsp"%>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <style>
    .custom-container {
      padding: 50px;
      margin: 10px;
    }
  </style>
</head>
<body>
  <div class="container custom-container">
    <h1>Golf Ranking</h1>
    <table class="table table-striped">
      <thead>
        <tr>
          <th>Rank</th>
          <th>Player</th>
          <th>Score</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Player A</td>
          <td>100</td>
        </tr>
        <tr>
          <td>2</td>
          <td>Player B</td>
          <td>105</td>
        </tr>
        <!-- ... Other rows for players 3 to 9 -->
        <tr class="table-info">
          <td>10</td>
          <td>Player C</td>
          <td>110</td>
        </tr>
        <!-- ... Other rows for players 11 and beyond -->
      </tbody>
    </table>
  </div>
</body>
</html>