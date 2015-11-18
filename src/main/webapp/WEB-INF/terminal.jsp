<html>
    <head>
        <style>
            div.form {
                display: inline-block;
                margin: 0;
                vertical-align: top;
            }
            div.info {
                color: #090;
            }

            h2 {
                font-size: 1em;
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <div class="info">
            ${resultInfo}
        </div>
        <div class="form">
            <h2>Ticket reservation</h2>
            <form>
                <p>
                    <input type="submit" value="reserve">
                </p>
                <p>
                    Name:
                    <br>
                    <input type="text" name="name" value="Alexander">
                </p>
                <p>
                    Surname:
                    <br>
                    <input type="text" name="surname" value="Shoshin">
                </p>
                <p>
                    Patronymic:
                    <br>
                    <input type="text" name="patronymic" value="">
                </p>
                <p>
                    Birth date:
                    <br>
                    <input type="number" name="birthDay" min="1" max="31" step="1" value="16">
                    <input type="number" name="birthMonth" min="1" max="12" step="1" value="5">
                    <input type="number" name="birthYear" min="1980" max="2000" step="1" value="1987">
                </p>
                <p>
                    From:
                    <br>
                    <select name="departurePoint">
                      <option value="Tver">Tver</option>
                      <option value="Oslo">Oslo</option>
                    </select>
                </p>
                <p>
                    Departure time:
                    <br>
                    <input type="number" name="departureDay" min="1" max="31" step="1" value="1">
                    <input type="number" name="departureMonth" min="1" max="12" step="1" value="1">
                    <input type="number" name="departureYear" min="2016" max="2016" step="1" value="2016">
                    <br>
                    <input type="number" name="departureHours" min="0" max="23" step="1" value="12">
                    <input type="number" name="departureMinutes" min="0" max="59" step="1" value="0">
                </p>
                <p>
                    To:
                    <br>
                    <select name="destinationPoint">
                      <option value="Oslo">Oslo</option>
                      <option value="Tver">Tver</option>
                    </select>
                </p>
                <p>
                    Destination time:
                    <br>
                    <input type="number" name="destinationDay" min="1" max="31" step="1" value="1">
                    <input type="number" name="destinationMonth" min="1" max="12" step="1" value="2">
                    <input type="number" name="destinationYear" min="2016" max="2016" step="1" value="2016">
                    <br>
                    <input type="number" name="destinationHours" min="0" max="23" step="1" value="12">
                    <input type="number" name="destinationMinutes" min="0" max="59" step="1" value="0">
                </p>
            </form>
        </div>
        <div class="form">
            <h2>Ticket actions</h2>
            <form>
               <input type="submit" value="get ticket">
               <input type="text" name="getTicket" value="${ticketId}">
            </form>
            <form>
               <input type="submit" value="pay for ticket">
               <input type="text" name="payForTicket" value="${ticketId}">
            </form>
            <form>
               <input type="submit" value="return ticket">
               <input type="text" name="returnTicket" value="${ticketId}">
            </form>
        </div>
    </body>
</html>