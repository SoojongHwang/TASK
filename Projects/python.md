# 06.28

## Python usage

- show image

  ```python
  from PIL import Image

  img = Image.open('lut.png')
  img.show()
  ```

  ​

- array manipulation with numpy (ndarray <-> Image)

  ```python
  import numpy as np
  from PIL import Image

  img = Image.open('lut_amatorka.png')
  data = np.asarray(img)
  data.setflags(write=True)

  for x in range(96, 160, 1):
      for y in range(96, 160, 1):
          data[x, y] = [0, 0, 0]


  im = Image.fromarray(data)
  im.show()
  ```

- numpy 2D array assignment and convert to image

  ```python
  import numpy as np
  from PIL import Image

  width = 4
  height = 4

  img_mat = np.zeros((width, height, 3), 'uint8')

  img_mat[0][0] = (0, 0, 0)
  img_mat[0][1] = (255, 0, 0)
  img_mat[1][0] = (0, 255, 0)
  img_mat[1][1] = (0, 0, 255)

  img = Image.fromarray(img_mat)
  img.show()
  ```

  ​

