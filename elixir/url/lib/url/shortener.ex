defmodule URL.Shortener do

  def encode(url) do
    short_url = Base62.encode(url)
  end
  

  def decode(hash) do
    {:ok, url} = Base62.decode(hash)
  end

end
