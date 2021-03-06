// set the dimensions and margins of the graph
var margin = { top: 10, right: 30, bottom: 30, left: 60 },
    width = 860 - margin.left - margin.right,
    height = 400 - margin.top - margin.bottom;
// append the svg object to the body of the page
var svg = d3.select("#my_dataviz")
    .append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform",
        "translate(" + margin.left + "," + margin.top + ")");
//Read the data
d3.json("/api/regs",
    // Now I can use this dataset:
    function (data) {


        // Format date
        var parseDate = d3.timeParse("%Y-%m-%d");
        data = data.map(function (d) {
            d.stringdate=d.date;
            d.date = parseDate(d.date);
            return d;
        });

        // filte data
        data = data.filter(function (d) { return d.acessos != null; });

        // Add X axis --> it is a date format
        var x = d3.scaleTime()
            .domain(d3.extent(data, function (d) { return d.date; }))
            .range([0, width]);
        svg.append("g")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x));
        // Add Y axis
        var y = d3.scaleLinear()
            .domain(d3.extent(data, function (d) { return d.acessos; }))
            .range([height, 0]);
        svg.append("g")
            .call(d3.axisLeft(y));
        // Add the line
        svg.append("path")
            .datum(data)
            .attr("fill", "none")
            .attr("stroke", "red")
            .attr("stroke-width", 3)
            .attr("d", d3.line()
                .x(function (d) { return x(d.date) })
                .y(function (d) { return y(d.acessos) })
            )

            // create a tooltip
            var Tooltip = d3.select("#my_dataviz")
            .append("div")
            .style("opacity", 0)
            .attr("class", "tooltip")
            .style("background-color", "white")
            .style("border", "solid")
            .style("border-width", "2px")
            .style("border-radius", "5px")
            .style("padding", "5px")
            .style("color","black")

            // Three function that change the tooltip when user hover / move / leave a cell
            var mouseover = function(d) {
            Tooltip
            .style("opacity", 1)
            }
            var mousemove = function(d) {
            Tooltip
            .html("Data:"+d.stringdate + "\nAcessos: " + d.acessos)
            .style("left", (d3.mouse(this)[0]+70) + "px")
            .style("top", (d3.mouse(this)[1]) + "px")
            }
            var mouseleave = function(d) {
            Tooltip
            .style("opacity", 0)
            }

        // Add the points
        svg
            .append("g")
            .selectAll("dot")
            .data(data)
            .enter()
            .append("circle")
            .attr("cx", function (d) { return x(d.date) })
            .attr("cy", function (d) { return y(d.acessos) })
            .attr("r", 4)
            .attr("fill", "black")
    })