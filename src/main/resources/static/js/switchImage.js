var img = 0;

function switchImage(i, d) {
	const imgs = 4;
	img += d;
	console.log(img);
	if (img >= imgs) {
		img = 1;
	} else if (img <= 1) {
		img = imgs - 1;
	}
	i.src = "/images/hotel-" + img + ".jpg";
}