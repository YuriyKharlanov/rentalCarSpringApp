<#macro inputRentalCarsinfo>
    <form method="post">
        <div><label for="carId">Выберите автомобиль:</label>
            <select id="carId" name="carId">
                <#list carList as cars>
                <option value="${cars.id}">${cars.vendorModelName}</option>
                </#list>
            </select>
        </div>

        <div><label> Дата выдачи в аренду : <input type="date" id="toRental" name="toRental" required="required" /> </label></div>
        <div><label> Дата возврата из аренды : <input type="date" id="fromRental" name="fromRental" required="required" /> </label></div>

        <div><label for="customers">Выберите имя арендатора:</label>
            <select id="customers" name="customers">
                <#list customerList as customer>
                    <option value="${customer.id}">${customer.fullName}</option>
                </#list>
            </select>
        </div>

        <div><label for="rentalPoint">Выберите пункт проката:</label>
            <select id="rentalPoint" name="rentalPoint">
                <#list rentalPointsList as rentalPoints>
                    <option value="${rentalPoints.id}">${rentalPoints.pointName}</option>
                </#list>
            </select>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Добавить" class="btn btn-primary" /></div>
    </form>
</#macro>