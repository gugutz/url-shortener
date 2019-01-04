defmodule URL.Shortener do

  def encode(url) do
    hash = Base62.encode(url)
    urls = URL.Bucket.get_state(:urls)

    case Map.has_key?(urls, hash) do
      true ->
        IO.puts "this url has already been encoded. heres the hash."
        hash
      false ->
        {:ok, url} = Base62.decode(hash)
        URL.Bucket.put(:urls, hash, url)
        IO.puts "url shortened and saved."
    end
  end

  def decode(hash) do
    urls = URL.Bucket.get_state(:urls)

    case Map.has_key?(urls, hash) do
      true ->
        IO.puts "found the url."
        URL.Bucket.get(:urls, hash)
      false ->
        IO.puts "this key doenst exist in the map"
    end
  end

end
