</div>
</div>
<script>
	$(document).ready(function() {
		$(".peso-format").each(function(index) {
			var value = $(this).html().split(".");
			var whole = value[0];
			if (whole != "-") {
				var decimal = ".".concat(value[1]);
				$(this).html(whole);
				$(this).after("<small class='decimal-value'>" + decimal + "</small>");
			}
		});
	});
</script>
</body>
</html>